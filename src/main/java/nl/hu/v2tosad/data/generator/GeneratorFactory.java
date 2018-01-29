package nl.hu.v2tosad.data.generator;

public class GeneratorFactory {
    public static Generator getGenerator(String dbType){
        Generator g = null;
        if (dbType==("Oracle")){
            return new OracleGenerator();
        } /*else
        if (dbType.equals("Postgres")){
            return new RocketEnemyShip();
        } else
        if (dbType.equals("Mysql")){
            return new BigUFOEnemyShip();
        } */
        else{return g;}

    }
}
