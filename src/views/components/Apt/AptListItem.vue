<template>
  <div class="aptinfo p-3 mb-3">
    <h3 class="display-4">{{ param.aptName }}</h3>
    <div class="detail">
      <strong>거래 금액: </strong>{{ param.houseDealDto.dealAmount.trim() }}원
      <br />
      <strong>면적: </strong>{{ param.houseDealDto.area }}m<sup>2</sup>
      <div></div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    param: Object,
  },
};
</script>

<style>
.aptinfo {
  width: 100%;
  height: fit-content;
  border-radius: 1rem;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
}

.detail {
  font-size: large;
}

.detail strong {
  color: #5e72e4;
}
</style>
