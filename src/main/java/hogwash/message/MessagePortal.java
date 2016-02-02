package hogwash.message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/messageportal/{roomId}", encoders = { MessageEncoder.class }, decoders = {
    MessageDecoder.class })
public class MessagePortal
{
  private static final Map< Integer, List< Session > > sessionsMap =
      new ConcurrentHashMap< Integer, List< Session > >();

  @OnOpen
  public void onOpen(@PathParam("roomId") int roomId,
                     Session session)
  {
    // TODO: check if user has access to room
    List< Session > sessionsList;
    sessionsList = sessionsMap.get( roomId );

    if ( sessionsList == null )
    {
      sessionsList = Collections.synchronizedList( new ArrayList< Session >() );
    }
    sessionsList.add( session );
    sessionsMap.put( roomId, sessionsList );
  }

  @OnClose
  public void onClose(@PathParam("roomId") int roomId,
                      Session currentSession)
  {
    List< Session > sessionsList = sessionsMap.get( roomId );
    sessionsList.forEach( session -> {
      if ( session.getId().equals( currentSession.getId() ) )
      {
        sessionsList.remove( currentSession );
      }
    } );
  }

  @OnMessage
  public void onMessage(@PathParam("roomId") int roomId,
                        Message message)
  {
    List< Session > sessionsList = sessionsMap.get( roomId );
    sessionsList.forEach( session -> {
      sendMessage( session, message );
    } );
  }

  private void sendMessage(Session session,
                           Message message)
  {
    if ( session.isOpen() )
    {
      try
      {
        session.getBasicRemote().sendObject( message );
      }
      catch ( IOException | EncodeException e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
