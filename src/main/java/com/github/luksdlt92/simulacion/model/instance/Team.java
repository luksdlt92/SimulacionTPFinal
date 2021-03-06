package com.github.luksdlt92.simulacion.model.instance;

import com.github.luksdlt92.simulacion.constant.Seniority;
import com.github.luksdlt92.simulacion.fdp.ComplexityPointsDev;

public class Team {

	private static final int DAYS_PER_SPRINT = 10;
	
    private final int technology;
    private final int[] devs = new int[3];
    private final int hoursWork;

    private int estimatedPoints = 0;
    private int developedPoints = 0;

    public Team(int technology, int devsSenior, int devsSemiSenior, int devsJunior, int hoursWork) {
        this.technology = technology;
        this.devs[Seniority.JUNIOR] = devsJunior;
        this.devs[Seniority.SEMISENIOR] = devsSemiSenior;
        this.devs[Seniority.SENIOR] = devsSenior;
        this.hoursWork = hoursWork;
    }

    /**
     * Calcula los puntos estimados por el equipo para el sprint
     * Tiene que llamarse por cada sprint
     */
    public int estimateSprint() {
        /*// for each seniority
        for (int seniority = 0; seniority < devs.length; seniority++) {
            // for each dev
            for (int i = 0; i < devs[seniority]; i++) {
                estimatedPoints += ComplexityPointsDev.getEstimatedPointsPerSprint(technology, seniority);
            }
        }*/
    	
    	/*estimatedPoints = new Double(ComplexityPointsDev.getEstimatedPointsPerSprint(this.technology, -1) 
    			* hoursWork * DAYS_PER_SPRINT * this.cantDevs() ).intValue();*/
	    
    	estimatedPoints = new Double(ComplexityPointsDev.getEstimatedPointsPerSprint(this.technology, hoursWork)).intValue();
    	
    	//System.out.println("Estimated points: " + new Integer(estimatedPoints).toString() );

        return estimatedPoints;
    }

    /**
     * Calcula los puntos efectivamente hechos por el equipo para el sprint
     * Tiene que llamarse por cada sprint, después de estimateSprint preferentemente
     */
    public int developSprint() {
    	
    	double developedPoints = 0;
        // for each seniority
        for (int seniority = 0; seniority < devs.length; seniority++) {
            // for each dev
            for (int i = 0; i < devs[seniority]; i++) {
                // for each hour of work
                for (int i2 = 0; i2 < hoursWork * DAYS_PER_SPRINT; i2++) {
                    developedPoints += ComplexityPointsDev.getCompletedPointsPerHour(technology, seniority);
                }
            }
        }

        //developedPoints = new Double(ComplexityPointsDev.getEstimatedPointsPerSprint(this.technology, hoursWork)).intValue();
        
    	//System.out.println("Developed points: " + new Double(developedPoints).toString() );
    	
        return new Double(developedPoints).intValue();
    }

    /**
     * Limpia los puntos estimados y desarrollados
     * Tiene que llamarse al finalizar un sprint o al iniciarse uno nuevo
     */
    public void cleanUp() {
        estimatedPoints = 0;
        developedPoints = 0;
    }
    
    private int cantDevs(){
    	int sum = 0;
    	for(int i=0;i<devs.length;i++){
    		sum += devs[i];
    	}
    	return sum;
    }
}
