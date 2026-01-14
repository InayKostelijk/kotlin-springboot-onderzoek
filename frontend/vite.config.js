import { defineConfig } from "vite";

export default defineConfig({
    server: {
        proxy: {
            "/api": "http://localhost:8080/",
        },
        host: true,
        port: 5173,
        watch: {
            usePolling: true,
        },
    },
});
