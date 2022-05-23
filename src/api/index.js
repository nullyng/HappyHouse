import axios from "axios";
axios.defaults.withCredentials = true;
import { API_BASE_URL } from "@/config";

// axios 객체 생성
function apiInstance() {
  const instance = axios.create({
    baseURL: API_BASE_URL,
    headers: {
      "Content-type": "application/json; charset=UTF-8",
    },
  });
  return instance;
}

export { apiInstance };
