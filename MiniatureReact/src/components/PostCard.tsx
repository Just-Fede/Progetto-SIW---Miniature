import type { Post } from '../types'

export function PostCard({ post }: { post: Post }) {
  // Recuperiamo la prima immagine utile se esiste
  const primaImmagine = post.immagini && post.immagini.length > 0 ? post.immagini[0].url : null;
  const utenteId = post.utente?.id;
  const username = post.utente?.credenziali?.username || 'Utente sconosciuto';

  return (
    <div 
      style={{
        background: 'white',
        border: '1px solid #e2e8f0',
        borderRadius: '12px',
        padding: '20px',
        boxShadow: '0 4px 6px rgba(0,0,0,0.02)',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
        transition: 'transform 0.2s, box-shadow 0.2s',
        cursor: 'pointer'
      }}
      onMouseEnter={(e) => {
        e.currentTarget.style.transform = 'translateY(-4px)';
        e.currentTarget.style.boxShadow = '0 8px 20px rgba(0,0,0,0.06)';
      }}
      onMouseLeave={(e) => {
        e.currentTarget.style.transform = 'none';
        e.currentTarget.style.boxShadow = '0 4px 6px rgba(0,0,0,0.02)';
      }}
    >
      <div>
        {/* Intestazione Autore con Foto Profilo */}
        <div style={{ marginBottom: '16px', display: 'flex', alignItems: 'center', gap: '10px' }}>
          {/* Avatar dell'utente */}
          {utenteId && (
            <img 
              src={
                post.utente?.urlFotoProfilo 
                  ? `http://localhost:8080${post.utente.urlFotoProfilo}`
                  : 'http://localhost:8080/img/fotoProfilo/default.jpg'
              } 
              alt="avatar"
              style={{
                width: '35px',
                height: '35px',
                borderRadius: '50%',
                objectFit: 'cover',
                border: '1px solid #764ba2',
                background: '#f0f2f5'
              }}
              onError={(e) => {
                e.currentTarget.src = 'http://localhost:8080/img/fotoProfilo/default.jpg';
              }}
            />
          )}

          <div style={{ display: 'flex', flexDirection: 'column' }}>
            <span style={{ fontSize: '0.75rem', color: '#718096', lineHeight: '1' }}>Caricato da:</span>
            {utenteId ? (
              <a 
                href={`http://localhost:8080/profilo/${utenteId}`}
                style={{ fontWeight: 'bold', color: '#764ba2', textDecoration: 'none', fontSize: '0.95rem', marginTop: '2px' }}
              >
                @{username}
              </a>
            ) : (
              <span style={{ fontWeight: 'bold', color: '#a0aec0', fontSize: '0.95rem', marginTop: '2px' }}>@{username}</span>
            )}
          </div>
        </div>

        {/* Link al dettaglio del Post su Thymeleaf applicato su tutto il corpo sotto l'autore */}
        <a 
          href={`http://localhost:8080/post/${post.id}`} 
          style={{ textDecoration: 'none', color: 'inherit', display: 'block' }}
        >
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start', gap: '10px' }}>
            <h3 style={{ color: '#2d3748', margin: '0 0 8px 0', fontSize: '1.25rem', lineHeight: '1.3' }}>
              {post.titolo}
            </h3>
            <span style={{ fontSize: '0.8rem', color: '#a0aec0', whiteSpace: 'nowrap', background: '#f7fafc', padding: '4px 8px', borderRadius: '4px' }}>
              {post.data}
            </span>
          </div>

          <p style={{ color: '#4a5568', fontSize: '0.95rem', lineHeight: '1.5', margin: '10px 0' }}>
            {post.descrizione}
          </p>

          {/* Render dell'Immagine (se presente) */}
          {primaImmagine && (
            <div style={{ marginTop: '15px', width: '100%', height: '220px', overflow: 'hidden', borderRadius: '8px', background: '#f8f9fa', border: '1px solid #edf2f7' }}>
              <img 
                src={`http://localhost:8080/uploads/${primaImmagine}`} 
                alt={post.titolo} 
                style={{
                  width: '100%',
                  height: '100%',
                  objectFit: 'contain'
                }}
                onError={(e) => {
                  console.error("ERRORE DI CARICAMENTO SU: ", e.currentTarget.src);
                }}
              />
            </div>
          )}
        </a>
      </div>
    </div>
  );
}