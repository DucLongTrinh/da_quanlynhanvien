package util;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.IOException;
//
//public class JsonUtil {
//
//  private static final ObjectMapper objectMapper = new ObjectMapper();
//
//  public static String toJson(Object object) {
//    try {
//      return objectMapper.writeValueAsString(object);
//    } catch (IOException e) {
//      e.printStackTrace();
//      return null;
//    }
//  }
//
//  public static <T> T fromJson(String jsonString, Class<T> valueType) {
//    try {
//      return objectMapper.readValue(jsonString, valueType);
//    } catch (IOException e) {
//      e.printStackTrace();
//      return null;
//    }
//  }
//}
