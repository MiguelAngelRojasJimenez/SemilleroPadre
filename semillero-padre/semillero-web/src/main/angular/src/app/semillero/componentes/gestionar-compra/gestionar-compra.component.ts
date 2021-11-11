import { Component, OnInit } from '@angular/core';
import { GestionarComicService } from 'src/app/semillero/servicios/gestionar-comic.service';

@Component({
  selector: 'app-gestionar-compra',
  templateUrl: './gestionar-compra.component.html',
  styleUrls: ['./gestionar-compra.component.css']
})
export class GestionarCompraComponent implements OnInit {

  constructor( private gestionComicsService : GestionarComicService) { }

  ngOnInit() {
    this.comprarComic
  }

 public comprarComic(){
    this.gestionComicsService.comprarComic().subscribe(data =>{
      if (data.exitoso){}
    })

}
}
