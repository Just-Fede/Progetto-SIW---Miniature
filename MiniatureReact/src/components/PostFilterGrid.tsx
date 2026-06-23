import { useState } from 'react'
import { PostCard } from './PostCard'
import type { Post } from '../types'

export function PostFilterGrid({ posts }: { posts: Post[] }) {
  const [searchFilter, setSearchFilter] = useState('')

  const postsSicuri = Array.isArray(posts) ? posts : [];

  const filtered = postsSicuri.filter((p) => {
    const cercato = searchFilter.toLowerCase()
    const matchTitolo = p.titolo?.toLowerCase().includes(cercato) || false
    const username = p.utente?.credenziali?.username?.toLowerCase() || ''
    const matchAutore = username.includes(cercato)
    return matchTitolo || matchAutore
  })

  return (
    <div>
      {/* Container di Ricerca stilizzato */}
      <div style={{
        background: 'white',
        padding: '20px',
        borderRadius: '12px',
        boxShadow: '0 2px 10px rgba(0,0,0,0.04)',
        border: '1px solid #e2e8f0',
        marginBottom: '30px',
        display: 'flex',
        flexDirection: 'column',
        gap: '10px'
      }}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
          <label style={{ fontWeight: 600, color: '#4a5568', display: 'flex', alignItems: 'center', gap: '6px' }}>
            🔍 Cerca nell'Hub delle Miniature:
          </label>
          <span style={{ fontSize: '0.9rem', color: '#718096', background: '#edf2f7', padding: '4px 10px', borderRadius: '20px', fontWeight: 'bold' }}>
            Post trovati: {filtered.length}
          </span>
        </div>
        
        <input 
          type="text"
          value={searchFilter}
          onChange={(e) => setSearchFilter(e.target.value)}
          placeholder="Inserisci il titolo del post o lo username dell'autore..."
          style={{
            width: '100%',
            padding: '12px 16px',
            borderRadius: '8px',
            border: '1px solid #cbd5e0',
            fontSize: '1rem',
            outline: 'none',
            transition: 'border-color 0.2s',
            boxSizing: 'border-box'
          }}
          onFocus={(e) => e.target.style.borderColor = '#764ba2'}
          onBlur={(e) => e.target.style.borderColor = '#cbd5e0'}
        />
      </div>

      {/* Griglia responsive dei Post */}
      {filtered.length === 0 ? (
        <p style={{ textAlign: 'center', color: '#a0aec0', marginTop: '4px' }}>Nessun post corrisponde ai criteri di ricerca.</p>
      ) : (
        <div style={{
          display: 'grid',
          gridTemplateColumns: 'repeat(auto-fill, minmax(340px, 1fr))',
          gap: '25px'
        }}>
          {filtered.map(post => (
            <PostCard key={post.id} post={post} />
          ))}
        </div>
      )}
    </div>
  )
}