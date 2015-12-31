package hogwash.message;

import java.io.IOException;
import java.io.Writer;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class MessageEncoder implements Encoder.TextStream< Message >
{

  @Override
  public void init(EndpointConfig config)
  {}

  @Override
  public void destroy()
  {}

  @Override
  public void encode(Message message,
                     Writer writer) throws EncodeException, IOException
  {
    JsonFactory jfactory = new JsonFactory();
    JsonGenerator jGenerator = jfactory.createGenerator( writer );
    jGenerator.writeStartObject(); // {
    jGenerator.writeNumberField( Message.Fields.ROOM_ID, message.getRoomId() );
    jGenerator.writeNumberField( Message.Fields.USER_ID, message.getUserId() );
    jGenerator.writeStringField( Message.Fields.MSG, message.getMessage() );
    jGenerator.writeEndObject(); // }
    jGenerator.close();
  }
}
