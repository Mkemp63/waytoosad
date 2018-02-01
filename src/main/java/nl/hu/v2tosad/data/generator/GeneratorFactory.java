package nl.hu.v2tosad.data.generator;

// Factory Method (Design Pattern), with this class we can get a specific database sql generator at run-time
public class GeneratorFactory {
    public static Generator getGenerator(String dbType){
        Generator g = null;
        if (dbType.equals("Oracle")){
            return new OracleGenerator();
        } 
        else{return g;}

    }
}
