package it.uniroma3.siw.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.uniroma3.siw.repository.ImmagineRepository;
import it.uniroma3.siw.model.Immagine;
import it.uniroma3.siw.model.Post;

@Service
public class ImmagineService {

    private final ImmagineRepository immagineRepository;

    public static final String DIRECTORY = "uploads";

    public ImmagineService(ImmagineRepository immagineRepository) {
        this.immagineRepository = immagineRepository;
    }

    public void salvaCopertina(Post post, MultipartFile file) {
        Immagine img = salvaFile(post, file, true);
        immagineRepository.save(img);
    }

    public void salvaGalleria(Post post, MultipartFile[] files) {
        for (MultipartFile file : files) {
            Immagine img = salvaFile(post, file, false);
            immagineRepository.save(img);
        }
    }

    private Immagine salvaFile(Post post, MultipartFile file, boolean copertina) {

        try {
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            java.nio.file.Path path = java.nio.file.Paths.get(DIRECTORY, filename);
            java.nio.file.Files.createDirectories(path.getParent());
            java.nio.file.Files.write(path, file.getBytes());

            Immagine img = new Immagine();
            img.setUrl(filename);
            img.setCopertina(copertina);
            img.setPost(post);

            return img;

        } catch (Exception e) {
            throw new RuntimeException("Errore salvataggio immagine", e);
        }
    }
}
