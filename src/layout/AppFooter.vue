<template>
  <footer class="footer">
    <div class="container container-lg">
      <div class="row"></div>
    </div>
    <div class="container">
      <div class="row align-items-center justify-content-md-between">
        <div class="col-md-6">
          <div class="copyright">
            &copy; {{ year }}
            <a
              href="https://github.com/nullyng/HappyHouse"
              target="_blank"
              rel="noopener"
              >SSAFY 7th</a
            >
          </div>
        </div>
        <hr />
        <div class="col-md-6">
          <ul class="nav nav-footer justify-content-end">
            <li class="nav-item">
              <a
                href="https://github.com/nullyng"
                class="nav-link"
                target="_blank"
                rel="noopener"
                >Juyoung Kim</a
              >
            </li>
            <li class="nav-item">
              <a
                href="https://github.com/yeinshin"
                class="nav-link"
                target="_blank"
                rel="noopener"
                >Yein shin</a
              >
            </li>
            <li class="nav-item">
              <a
                href="https://github.com/iinnu"
                class="nav-link"
                target="_blank"
                rel="noopener"
                >Inhu Jo</a
              >
            </li>
            
          </ul>
        </div>
      </div>
    </div>
  </footer>
</template>
<script>
export default {
  name: "AppFooter",
  data() {
    return {
      year: new Date().getFullYear(),
    };
  },
};
</script>
<style>
.footer {
  position: absolute;
  bottom: 0;
  width: 100%;
}
</style>
