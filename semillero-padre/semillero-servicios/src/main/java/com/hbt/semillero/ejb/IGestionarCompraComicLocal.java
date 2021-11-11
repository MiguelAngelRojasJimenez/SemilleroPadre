package com.hbt.semillero.ejb;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;

@Local
public interface IGestionarCompraComicLocal {

	public ComicDTO comprarComic(Long idComic, Integer cantidadComprada);
	
}
