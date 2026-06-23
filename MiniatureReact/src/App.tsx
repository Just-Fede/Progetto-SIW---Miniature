import { useEffect, useState } from 'react'
import { getPostList } from './services/postService'
import { PostFilterGrid } from './components/PostFilterGrid'
import type { Post } from './types'

function App() {
  const [posts, setPosts] = useState<Post[]>([])
  const [loading, setLoading] = useState(true)
  const [errore, setErrore] = useState<string | null>(null)

  useEffect(() => {
    getPostList()
      .then((data) => {
        // Logghiamo per sicurezza, stile debug del prof
        console.log("Dati puliti estratti da Axios:", data)
        
        if (Array.isArray(data)) {
          setPosts(data)
        } else {
          // Se Spring ha risposto con un oggetto d'errore anziché una lista
          setErrore("Il server non ha restituito una lista di post valida.")
        }
      })
      .catch((err) => {
        console.error("Errore Axios:", err)
        setErrore("Impossibile connettersi al backend. Controlla CORS o Spring Security.")
      })
      .finally(() => {
        setLoading(false)
      })
  }, [])

  return (
    <div style={{ padding: '20px', fontFamily: "'Segoe UI', sans-serif" }}>
      
      <nav style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '30px', paddingBottom: '15px', borderBottom: '1px solid #e2e8f0' }}>
        <h1 style={{ fontSize: '1.5rem', color: '#764ba2', margin: 0 }}>MiniatureHub — Ricerca Avanzata</h1>
        <a href="http://localhost:8080/" style={{ textDecoration: 'none', color: '#4a5568', fontWeight: 'bold', fontSize: '0.95rem' }}>
          ⬅ Torna alla Home
        </a>
      </nav>

      {loading && (
        <p style={{ textAlign: 'center', color: '#666', fontStyle: 'italic', marginTop: '50px' }}>
          Caricamento dati dal server Spring Boot...
        </p>
      )}

      {errore && (
        <div style={{ padding: '15px', background: '#fff5f5', color: '#c53030', borderRadius: '6px', border: '1px solid #feb2b2', margin: '20px auto', maxWidth: '600px', textAlign: 'center' }}>
          <strong>⚠️ Attenzione:</strong> {errore}
        </div>
      )}

      {!loading && !errore && (
        <PostFilterGrid posts={posts} />
      )}
    </div>
  )
}

export default App