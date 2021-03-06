package ch.epfl.sdp;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.GeoPoint;

import java.util.HashMap;
import java.util.Map;

import ch.epfl.sdp.db.DatabaseObjectBuilder;

public class EventDatabaseBuilder extends DatabaseObjectBuilder<Event> {
    @Override
    public Event buildFromMap(@NonNull Map data) {
        String title = (String) data.get("title");
        String description = (String) data.get("description");
        Timestamp timestamp = (Timestamp)data.get("date");
        GeoPoint location = (GeoPoint)data.get("location");
        return new Event(title, description, timestamp.toDate(),R.mipmap.ic_launcher,new LatLng(location.getLatitude(), location.getLongitude()));
    }

    @Override
    public Map<String, Object> serializeToMap(@NonNull Event event) {
        return new HashMap<String, Object>() {{
            put("title", event.getTitle());
            put("description", event.getDescription());
            put("date", new Timestamp(event.getDate()));
            put("location", new GeoPoint(event.getLocation().latitude, event.getLocation().longitude));
        }};
    }
}
