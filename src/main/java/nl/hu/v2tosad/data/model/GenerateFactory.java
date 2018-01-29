package nl.hu.v2tosad.data.model;

public class GenerateFactory {
    public static Generate doGenerate(String dbType){
        Generate g = null;
        if (dbType==("Oracle")){
            return new GenerateImplOracle();
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
