package model;

/**
 * Created by igdev on 10/11/14.
 */
public class Config {

    private double quiz;
    private double exposicion;
    private double project;
    private double practica;

    public static Config context = new Config();
    public static Config getInstance(){
        return context;
    }

    public Config(){
        this.quiz = 0.15;
        this.exposicion = 0.10;
        this.practica = 0.40;
        this.project = 0.35;
    }
    public double getQuiz() {
        return quiz;
    }

    public void setQuiz(double quiz) {
        this.quiz = quiz;
    }

    public double getExposicion() {
        return exposicion;
    }

    public void setExposicion(double exposicion) {
        this.exposicion = exposicion;
    }

    public double getProject() {
        return project;
    }

    public void setProject(double project) {
        this.project = project;
    }

    public double getPractica() {
        return practica;
    }

    public void setPractica(double practica) {
        this.practica = practica;
    }
}
