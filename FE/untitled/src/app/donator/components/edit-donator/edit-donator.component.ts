import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Donator} from "../../models/donator";
import {CreateDonatorService} from "../../services/createdonator.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-edit-donator',
  templateUrl: './edit-donator.component.html',
  styleUrls: ['./edit-donator.component.css']
})
export class EditDonatorComponent implements OnInit {
  // @ts-ignore
  id: number;
  isSuccess: boolean = false;

  constructor(private route: ActivatedRoute,
              private donatorService: CreateDonatorService,
              private router: Router) {
  }

  donatorDetails: Donator = new Donator(BigInt(-1),"Firstname","Lastname","Additionalname","Maidenname");
  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      // @ts-ignore
      const donorId = +params.get('id');
      this.donatorService.getDonor(donorId).subscribe((donatorData: Donator) => {
        this.donatorDetails = donatorData;

      });
    });
  }
  saveDonator(): void {
    this.donatorService.saveDonator(this.donatorDetails);
    this.isSuccess = true;
  }
  navigateToEditDonator(): void {
    this.router.navigate(['/donator/edit']); // Navigate to the desired URL
  }
}
