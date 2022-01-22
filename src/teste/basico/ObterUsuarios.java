package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ObterUsuarios {

    public static void main(String[] args) {

        EntityManagerFactory fabricaGerenteEntidade =
                Persistence.createEntityManagerFactory("exercicios-jpa");
        EntityManager gerenteEntidade = fabricaGerenteEntidade.createEntityManager();

        String jpql = "select u from Usuario u";
        //consulta por TIPO de classe
        TypedQuery<Usuario> query = gerenteEntidade.createQuery(jpql,Usuario.class);
        //quantos resultados maximos quer ter
        query.setMaxResults(5);
        //vai ter o resultado e jogar dentro de "usuarios/lista"
        List<Usuario>usuarios = query.getResultList();

        for (Usuario usuario:usuarios){
            System.out.println("ID: "+usuario.getId()+" E-mail: "+usuario.getEmail());
        }


        gerenteEntidade.close();
        fabricaGerenteEntidade.close();
    }

}
