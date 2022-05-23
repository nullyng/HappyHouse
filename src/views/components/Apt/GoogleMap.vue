<template>
  <div>
    <gmap-map :zoom="16" :center="center" style="width: 100%; height: 600px">
      <gmap-marker
        :key="index"
        v-for="(item, index) in aptlist"
        :position="{ lat: item.lat, lng: item.lng }"
      >
        <gmap-info-window :opened="true">
          <div>
            <h5>
              <strong>{{ item.aptName }}</strong>
            </h5>
            <div class="detail">
              <strong>거래 금액: </strong
              >{{ item.houseDealDto.dealAmount.trim() }}만원
              <br />
              <strong>면적: </strong>{{ item.houseDealDto.area }}m<sup>2</sup>
            </div>
          </div>
        </gmap-info-window>
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
      locationMarkers: [],
      locPlaces: [],
      existingPlace: null,
    };
  },
  computed: {
    center() {
      return { lat: Number(this.lat), lng: Number(this.lng) };
    },
  },
};
</script>

<style scoped>
.detail {
  font-size: large;
}

.detail strong {
  color: #32325d;
}
</style>
