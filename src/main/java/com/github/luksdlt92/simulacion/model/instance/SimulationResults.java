package com.github.luksdlt92.simulacion.model.instance;

public class SimulationResults {
	
	private SimulationInstance2 simulation;
	private boolean algunEquipoFallo = Boolean.FALSE;
    private boolean algunEquipoOcioso = Boolean.FALSE;
    private int puntosNoCumplidos = 0;
    private int puntosSobrantes = 0;
    private int puntosNoProbados = 0;
    private int noCompletaPrioridad = 0;
    private int noCompletaComun = 0;
    private int qaOcioso = 0;
	private double puntosSobrantesQa = 0;
	private int sprintFallidos = 0;
	private int sprintOciosos = 0;
	//Resultados
	private double porcentajeSprintsFallidos = 0;
    private double porcentajeSprintsOciosos = 0;
    private double promedioPuntosSobrantesPorSprintYEquipo = 0;
    private double promedioPuntosFaltantesPorSprintYEquipo = 0;
    private double porcentajeQaNoCompletaPrioridad = 0;
    private double porcentajeQaNoCompletaComun = 0;
    private double porcentajeQaOcioso = 0;
    
    public SimulationResults(SimulationInstance2 simulation){
    	this.simulation=simulation;
    }

    public void calcularResultados(){
    	this.porcentajeSprintsFallidos = this.sprintFallidos / this.simulation.getCantSprintsFinal()* 100;
    	this.porcentajeSprintsOciosos = this.sprintOciosos / this.simulation.getCantSprintsFinal() * 100;
    	this.promedioPuntosSobrantesPorSprintYEquipo = this.puntosSobrantes / (this.simulation.getCantSprintsFinal() * this.simulation.getCantEquipos());
    	this.promedioPuntosFaltantesPorSprintYEquipo = this.puntosNoCumplidos / (this.simulation.getCantSprintsFinal() * this.simulation.getCantEquipos());
    	this.porcentajeQaNoCompletaPrioridad = this.noCompletaPrioridad / this.simulation.getCantSprintsFinal() * 100;
    	this.porcentajeQaNoCompletaComun = this.noCompletaComun / this.simulation.getCantSprintsFinal() * 100;
    	this.porcentajeQaOcioso = this.qaOcioso / this.simulation.getCantSprintsFinal() * 100;
    }
    public void imprimir(){
    	System.out.println("Porcentaje de veces que QA no alcanzó a probar la totalidad de los puntos de prioridad: "+ porcentajeQaNoCompletaPrioridad);
    	System.out.println("Porcentaje de veces que QA no alcanzó a probar la totalidad de los puntos: "+ porcentajeQaNoCompletaComun);
    	System.out.println("Porcentaje de veces que algún equipo no pudo cumplir con la cantidad de puntos requeridos: " + porcentajeSprintsFallidos);
    	System.out.println("Porcentaje de veces que el equipo del proyecto estuvo ocioso: " + porcentajeSprintsOciosos);
    	System.out.println(": "+ porcentajeQaOcioso);
    	System.out.println("Promedio de sobrante de horas de QA: "+ promedioPuntosSobrantesPorSprintYEquipo);
    	System.out.println("Promedio de faltante de horas de QA: "+ promedioPuntosFaltantesPorSprintYEquipo);
    }

	public boolean isAlgunEquipoFallo() {
		return algunEquipoFallo;
	}
	public void setAlgunEquipoFallo(boolean algunEquipoFallo) {
		this.algunEquipoFallo = algunEquipoFallo;
	}

	public boolean isAlgunEquipoOcioso() {
		return algunEquipoOcioso;
	}
	public void setAlgunEquipoOcioso(boolean algunEquipoOcioso) {
		this.algunEquipoOcioso = algunEquipoOcioso;
	}

	public int getPuntosNoCumplidos() {
		return puntosNoCumplidos;
	}
	public void sumarPuntosNoCumplidos(int puntosNoCumplidos){
		this.puntosNoCumplidos += puntosNoCumplidos;
	}
	
	public int getPuntosSobrantes() {
		return puntosSobrantes;
	}
	public void sumarPuntosSobrantes(int puntosSobrantes) {
		this.puntosSobrantes += puntosSobrantes;
	}

	public int getPuntosNoProbados() {
		return puntosNoProbados;
	}
	public void sumarPuntosNoProbados(int puntosNoProbados) {
		this.puntosNoProbados += puntosNoProbados;
	}

	public int getNoCompletaPrioridad() {
		return noCompletaPrioridad;
	}
	public void increaseNoCompletaPrioridad(){
		this.noCompletaPrioridad ++;
	}

	public int getNoCompletaComun() {
		return noCompletaComun;
	}
	public void increaseNoCompletaComun(){
		this.noCompletaComun ++;
	}

	public int getQaOcioso() {
		return qaOcioso;
	}
	public void increaseQaOcioso(){
		this.qaOcioso ++;
	}

	public double getPuntosSobrantesQa() {
		return puntosSobrantesQa;
	}
	public void sumarPuntosSobrantesQa(double puntosSobrantesQa){
		this.puntosSobrantesQa++;
	}

	public int getSprintFallidos() {
		return sprintFallidos;
	}
	public void increaseSprintFallidos(){
		this.sprintFallidos++;
	}

	public int getSprintOciosos() {
		return sprintOciosos;
	}
	public void increaseSprintOciosos(){
		this.sprintOciosos++;
	}

	public double getPorcentajeSprintsFallidos() {
		return porcentajeSprintsFallidos;
	}

	public double getPorcentajeSprintsOciosos() {
		return porcentajeSprintsOciosos;
	}

	public double getPromedioPuntosSobrantesPorSprintYEquipo() {
		return promedioPuntosSobrantesPorSprintYEquipo;
	}

	public double getPromedioPuntosFaltantesPorSprintYEquipo() {
		return promedioPuntosFaltantesPorSprintYEquipo;
	}

	public double getPorcentajeQaNoCompletaPrioridad() {
		return porcentajeQaNoCompletaPrioridad;
	}

	public double getPorcentajeQaNoCompletaComun() {
		return porcentajeQaNoCompletaComun;
	}

	public double getPorcentajeQaOcioso() {
		return porcentajeQaOcioso;
	}

}