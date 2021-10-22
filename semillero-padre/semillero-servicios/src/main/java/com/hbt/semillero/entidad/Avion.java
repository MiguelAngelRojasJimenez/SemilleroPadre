package com.hbt.semillero.entidad;

import com.hbt.semillero.enums.TipoVehiculoEnum;
import com.hbt.semillero.interfaces.AccionesVehiculoInterface;

public class Avion extends Vehiculo implements AccionesVehiculoInterface {

	@Override
	public int obtenerVelocidadMaxima() {
		return 700;
	}

	@Override
	public Long obternerPesoMaximoCarga() {
		return 50L;
	}

	@Override
	public boolean determinarTipoVehiculo(TipoVehiculoEnum tipoVehiculoEmun) throws Exception {
		if(getTipovehiculo().getIdentificador() == (tipoVehiculoEmun.getIdentificador())) {
			System.out.println("El vehiculo si es del mismo tipo");
			return true;
		} else {
			throw new Exception("El tipo de vehiculo asignado es erroneo, debe ser Areo");
		}
	}	
}
