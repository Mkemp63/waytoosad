package nl.hu.v2tosad.data.generator;

public class GeneratorFactory {
    public static Generator getGenerator(String dbType){
        Generator g = null;
        if (dbType.equals("Oracle")){
            return new OracleGenerator();
        } 
        else{return g;}

    }
}
