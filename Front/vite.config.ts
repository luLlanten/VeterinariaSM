import react from '@vitejs/plugin-react'
import { defineConfig } from 'vite'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      '/lobby': {
        target: 'http://localhost:9090',
        changeOrigin: true,
      }
    }
  }
})
