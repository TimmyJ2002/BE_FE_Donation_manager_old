import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CampaignService} from "../../services/campaign.service";

@Component({
  selector: 'app-campaign-delete',
  templateUrl: './campaign-delete.component.html',
  styleUrls: ['./campaign-delete.component.css']
})
export class CampaignDeleteComponent implements OnInit{

  campaignForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private campaignService: CampaignService) {
    this.campaignForm = this.formBuilder.group( {
      name:[''],
      purpose: ['']
    });
  }

  // onSubmit() {
  //   if (this.campaignForm.valid) {
  //     const campaignData = this.campaignForm.value;
  //     this.campaignService.deleteCampaign(campaignData).subscribe(
  //       (response) => {
  //         console.log('Campaign deleted: ', response);
  //       },
  //       (error) => {
  //         console.error('Error deleting campaign: ', error);
  //       }
  //     );
  //   }
  // }

  ngOnInit(): void {
  }

}
