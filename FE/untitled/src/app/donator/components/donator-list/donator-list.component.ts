import {Component, OnInit} from '@angular/core';
import {CreateDonatorService} from "../../services/createdonator.service";
import {Router} from "@angular/router";
import {Donator} from "../../models/donator";

@Component({
  selector: 'app-donator-list',
  templateUrl: './donator-list.component.html',
  styleUrls: ['./donator-list.component.css']
})
export class DonatorListComponent implements OnInit{
  donors: any[] = [];
  selectedDonator: Donator | null = null; // To store the selected donator
  donator: Donator | null = null;

  constructor(private donorService: CreateDonatorService,
              private router: Router) {}

  ngOnInit(): void {
    this.loadDonors();
  }

  loadDonors(): void {
    this.donorService.getDonors().subscribe(donors => {
      this.donors = donors;
    });
  }

  selectDonator(donator: Donator): void {
    this.selectedDonator = donator; // Store the selected donator's information
  }
  navigateToEditDonator(donor: Donator): void {
    this.donator = donor;
    this.router.navigate(['donator/edit', donor.id]);
  }

}
