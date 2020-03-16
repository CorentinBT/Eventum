package ch.epfl.sdp.db;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseObjectBuilderFactory {

    private static final Map<Class, DatabaseObjectBuilder> mBuilders = new HashMap<>();

    public static <T> void registerBuilder(@NonNull Class<T> type, @NonNull Class<? extends DatabaseObjectBuilder<T>> builder)
            throws InstantiationException, IllegalAccessException {
        if(type == null || builder == null) {
            throw new IllegalArgumentException();
        }
        if(mBuilders.containsKey(type)) {
            throw new IllegalArgumentException();
        }
        mBuilders.put(type, builder.newInstance());
    }

    @Nullable
    public static <T> DatabaseObjectBuilder<T> getBuilder(@NonNull Class<T> type) {
        if(type == null) {
            throw new IllegalArgumentException();
        }
        return mBuilders.get(type);
    }

    public static void clear() {
        mBuilders.clear();
    }
}