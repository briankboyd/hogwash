package hogwash.message;

import java.io.IOException;
import java.io.Reader;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class MessageDecoder implements Decoder.TextStream< Message >
{

  @Override
  public void init(EndpointConfig config)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void destroy()
  {
    // TODO Auto-generated method stub

  }

  @Override
  public Message decode(Reader reader) throws DecodeException, IOException
  {
    JsonFactory jasonFactory = new JsonFactory();
    JsonParser jsonParser = jasonFactory.createParser( reader );
    Message message = new Message();

    // loop until token equal to "}"
    while ( jsonParser.nextToken() != JsonToken.END_OBJECT )
    {
      String fieldname = jsonParser.getCurrentName();
      if ( Message.Fields.ROOM_ID.equals( fieldname ) )
      {
        // current token is "name",
        // move to next, which is "name"'s value
        jsonParser.nextToken();
        message.setRoomId( jsonParser.getIntValue() );
        // System.out.println( jsonParser.getIntValue() );
      }
      if ( Message.Fields.USER_ID.equals( fieldname ) )
      {
        jsonParser.nextToken();
        message.setUserId( jsonParser.getIntValue() );
        // System.out.println( jsonParser.getIntValue() );
      }
      if ( Message.Fields.MSG.equals( fieldname ) )
      {
        jsonParser.nextToken();
        message.setMessage( jsonParser.getText() );
        // System.out.println( jsonParser.getText() );
      }
    }
    jsonParser.close();
    return message;
  }
}
