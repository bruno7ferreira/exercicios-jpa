package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuarios {

    public static void main(String[] args) {

        EntityManagerFactory fabricaGerenteEntidade =
                Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager gerenteEntidade = fabricaGerenteEntidade.createEntityManager();


    }

}
