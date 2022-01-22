package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuario {

    public static void main(String[] args) {

        //criando gerente de entidade
        EntityManagerFactory fabricaGerenteEntidade = Persistence
                .createEntityManagerFactory("exercicios-jpa");
        EntityManager gerenteEntidade = fabricaGerenteEntidade.createEntityManager();

        //pegando o resultado do usuário pelo Id
        Usuario usuario = gerenteEntidade.find(Usuario.class,3L);
        System.out.println(usuario.getNome());




        gerenteEntidade.close();
        fabricaGerenteEntidade.close();
    }

}
