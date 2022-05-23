<template>
  <div>
    <gmap-map :zoom="16" :center="center" style="width: 100%; height: 600px">
      <gmap-marker
        :key="index"
        v-for="(item, index) in aptlist"
        :position="{ lat: item.lat, lng: item.lng }"
      >
      </gmap-marker>
    </gmap-map>
  </div>
</template>
<script>
export default {
  name: "GoogleMap",
  props: {
    aptlist: Array,
    lat: {
      type: String,
      default: "37.5642135",
    },
    lng: {
      type: String,
      default: "127.0016985",
    },
  },
  data() {
    return {
      center: { lat: Number(this.lat), lng: Number(this.lng) },
      locationMarkers: [],
      locPlaces: [],
      existingPlace: null,
    };
  },
};
</script>
