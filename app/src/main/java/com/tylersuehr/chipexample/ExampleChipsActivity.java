package com.tylersuehr.chipexample;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.tylersuehr.chips.ChipsInputLayout;

import java.util.List;

/**
 * Copyright © 2017 Tyler Suehr
 *
 * @author Tyler Suehr
 * @version 1.0
 */
public class ExampleChipsActivity extends ContactLoadingActivity
        implements ContactOnChipAdapter.OnContactClickListener {
  private ContactOnChipAdapter contactAdapter;
  private ChipsInputLayout chipsInput;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_example_chips);


    // Setup the recycler
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setStackFromEnd(true);

    this.contactAdapter = new ContactOnChipAdapter(this);
    RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
    recycler.setLayoutManager(layoutManager);
    recycler.setHasFixedSize(true);

    recycler.setAdapter(contactAdapter);

    //mFilterableListElevation
    // Setup chips input
    this.chipsInput = (ChipsInputLayout) findViewById(R.id.chips_input);


    chipsInput.getmFilteredRecycler().fadeIn();

    // Load the current user's contact information
    loadContactsWithRuntimePermission();

    recycler.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(ExampleChipsActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
      }
    });
  }

  /**
   * When we have contact chips available, let's make them filterable in our ChipsInputView!
   */
  @Override
  protected void onContactsAvailable(List<ContactChip> chips) {
    System.out.println("Number of contacts: " + chips.size());
    this.chipsInput.setFilterableChipList(chips);

  }

  @Override
  protected void onContactsReset() {

  }

  @Override
  public void onContactClicked(ContactChip chip) {

  }
}