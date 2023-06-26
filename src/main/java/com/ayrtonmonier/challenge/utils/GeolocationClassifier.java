package com.ayrtonmonier.challenge.utils;

import com.ayrtonmonier.challenge.entities.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class GeolocationClassifier {
    // Coordenadas dos bounding boxes para cada rótulo
    private static final Map<String, BoundingBox> LABELS = new HashMap<>();

    
    static {
        // Obtém o idioma do sistema
        // Define as coordenadas dos bounding boxes para cada rótulo
        LABELS.put("ESPECIAL", new BoundingBox(-2.196998, -46.361899, -15.411580, -34.276938));
        LABELS.put("ESPECIAL", new BoundingBox(-19.766959, -52.997614, -23.966413, -44.428305));
        LABELS.put("NORMAL", new BoundingBox(-26.155681, -54.777426, -34.016466, -46.603598));
    }

    public static String classifyType(Location location, ResourceBundle messages) {
        // Coordenadas do cliente que deseja classificar
        double clienteLat = Double.parseDouble(location.getCoordinates().getLatitude());
        double clienteLon = Double.parseDouble(location.getCoordinates().getLongitude());

        // Verificar se o cliente está dentro de alguma bounding box
        for (Map.Entry<String, BoundingBox> entry : LABELS.entrySet()) {
            String label = entry.getKey();
            BoundingBox boundingBox = entry.getValue();

            if (boundingBox.contains(clienteLat, clienteLon)) {
                return messages.getString("rotulo." + label.toLowerCase());
            }
        }

        // Se o cliente não estiver dentro de nenhuma bounding box, retornar o rótulo "trabalhoso"
        return messages.getString("rotulo.trabalhoso");
    }

    private static class BoundingBox {
        private final double minLon;
        private final double minLat;
        private final double maxLon;
        private final double maxLat;

        public BoundingBox(double minLon, double minLat, double maxLon, double maxLat) {
            this.minLon = minLon;
            this.minLat = minLat;
            this.maxLon = maxLon;
            this.maxLat = maxLat;
        }

        public boolean contains(double lat, double lon) {
            return (lon >= minLon && lon <= maxLon) && (lat >= minLat && lat <= maxLat);
        }
    }
}
