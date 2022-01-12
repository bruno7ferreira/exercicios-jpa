package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {

    public static void main(String[] args) {

        //criando gerente de entidades
        EntityManagerFactory fabricaGerenteEntidade = Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager gerenteEntidade = fabricaGerenteEntidade.createEntityManager();

        //criando usuário
        Usuario novoUsuario = new Usuario("Nome","bruno.rogerio@brf.com");

        // persistir/inserir no banco de dados
        gerenteEntidade.getTransaction().begin();
        gerenteEntidade.persist(novoUsuario);
        gerenteEntidade.getTransaction().commit();


        gerenteEntidade.close();
        fabricaGerenteEntidade.close();
    }

}