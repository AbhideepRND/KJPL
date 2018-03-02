 <div class="content-wrapper">
    <!-- Actual Body Part -->
    <div class="container-fluid" id="viewHands">
      <div class="row">
        <div class="col-12">
          <h4>View Hands Entry</h4>
          <p>Here you can view the hands entry to generate report</p>
        </div>
      </div>
      <div class="line"></div>
      <br>
      <div class="row">
        <div class="col-2 col-sm-2 col-md-2">Date :-</div>
        <div class="col-2 col-sm-3 col-md-3"><input class="form-control date-field" id="entryDate" name="entryDate" type="text"></div>
        <div class="col-2 col-sm-2 col-md-2"><button class="btn btn-primary btn-sm " type="button" id="search" data-dismiss="modal">Search</button></div>
      </div>
      <br>
      <div class="row">
      	<div class="col-2 col-sm-2 col-md-2">Production :-</div>
        <div class="col-2 col-sm-3 col-md-2"><span id="production"></span>&nbsp;<span>(M/T)</span></div>
        <div class="col-2 col-sm-3 col-md-8">
        <span class="float-right" ><img style="height: 35px;width: 35px;" id="Excelreport" src="/static/img/Excel_image.png" alt="..." class="img-thumbnail" ></span>
        </div>
      </div>
      <br>
      <div>
        <table id="view-table" class="table" >
          <thead>
            <tr>
              <th>Department</th>
              <th>Permanent</th>
              <th>Special Badly</th>
              <th>Badly</th>
              <th>Learner (LN)</th>
              <th>Semi Skilled (TT)</th>
              <th>New Entrance</th>
              <th>Outsider Source (O/S)</th>
              <th>Other Mill (O/M)</th>
              <th>Voucher/Retired</th>
              <th>Total</th>
            </tr>
          </thead>
          <tbody id="tableView" align="center">
          </tbody>
        </table>
      </div>
    </div>
   </div>