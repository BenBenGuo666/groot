package groot.springboot.demo.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class JsonUtils {

    public static String toGson(Object object) {
        try {
            if (object == null) {
                return "";
            }
            return builderGson().toJson(object);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }

    private static Gson builderGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonSerializer<LocalDateTime>) (localDateTime, type, jsonSerializationContext) ->
                                new JsonPrimitive(DateUtils.dateTimeToMilli(localDateTime)))
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) -> {
                            try {
                                return LocalDateTime.ofEpochSecond(json.getAsJsonPrimitive().getAsLong(),
                                        0, ZoneOffset.ofHours(8));
                            } catch (Exception e) {
                                return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                            }
                        }
                )
                .create();
    }

    public static <T> T gsonToObj(String json, Type typeOfT) {
        try {
            if (StringUtils.isEmpty(json)) {
                return null;
            }
            return builderGson().fromJson(json, typeOfT);
        } catch (Throwable t) {

            t.printStackTrace();
        }
        return null;
    }


}
