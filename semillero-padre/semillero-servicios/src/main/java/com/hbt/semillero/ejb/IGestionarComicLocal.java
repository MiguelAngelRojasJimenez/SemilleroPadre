package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ActualizarComicDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;

@Local
public interface IGestionarComicLocal {
	
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic);

	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception;
	
	public ConsultaComicTamanioNombreDTO consultarTamanoComic (Short lengthComic);
	
	public ActualizarComicDTO actualizarComic();
	
	public ResultadoDTO eliminarComic(Long idComic);
	
	public List<ComicDTO> consultarComicDTO();
}
