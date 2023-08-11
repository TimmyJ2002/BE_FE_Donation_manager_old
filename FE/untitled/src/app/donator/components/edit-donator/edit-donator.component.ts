import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Donator} from "../../models/donator";

@Component({
  selector: 'app-edit-donator',
  templateUrl: './edit-donator.component.html',
  styleUrls: ['./edit-donator.component.css']
})
export class EditDonatorComponent implements OnInit{
  // @ts-ignore
  id: number;
  @Input() donatorDetails: any;

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit() {
    // @ts-ignore
    this.route.queryParams.subscribe((data)=>{
      this.id = data['id'];
    });
  }
}
