package br.edu.ifsul.sapucaia.lp.repository;

import br.edu.ifsul.sapucaia.lp.dominio.Mensagem;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMensagemRepository extends JpaRepository<Mensagem, Integer> {
    Optional<Mensagem> findById(Long id);
    @Query("select a from Mensagem a where (a.destinatario.username like :username or a.remetente.username like :username) and a.conteudo like %:conteudo% order by a.dataDeEnvio desc")
    Page<Mensagem> queryMensagens(@Param("username") String username, @Param("conteudo") String conteudo, Pageable pageable);
    
    @Query("select a from Mensagem a where a.remetente.username like :username and a.conteudo like %:conteudo% order by a.dataDeEnvio desc")
    Page<Mensagem> queryByRemetente(@Param("username") String remetente, @Param("conteudo") String conteudo, Pageable pageable);
    
    @Query("select a from Mensagem a where a.destinatario.username like :username and a.conteudo like %:conteudo% order by a.dataDeEnvio desc")
    Page<Mensagem> queryByDestinatario(@Param("username") String destinatario, @Param("conteudo") String conteudo, Pageable pageable);       

    @Query("select a from Mensagem a where (a.destinatario.username like :username1 and a.remetente.username like :username2) and a.conteudo like %:conteudo% order by a.dataDeEnvio desc")
    Page<Mensagem> queryMensagensRecebidasOuEnviadas(@Param("username1") String username1, @Param("username2") String username2, @Param("conteudo") String conteudo, Pageable pageable);

    @Query("select a from Mensagem a where ((a.destinatario.username like :username1 and a.remetente.username like :username2) or (a.destinatario.username like :username2 and a.remetente.username like :username1)) and a.conteudo like %:conteudo% order by a.dataDeEnvio desc")
    Page<Mensagem> queryMensagensRecebidasEEnviadas(@Param("username1") String username1, @Param("username2") String username2, @Param("conteudo") String conteudo, Pageable pageable);
}