<div class="content-wrapper">
    <!-- Actual Body Part -->
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <div class="row">
        <div class="col-12">
          <h1>Rate Entry</h1>
          <p>Here you can add the rate of employees type</p>
          <div class="form-group" id="RateEntry">
          	<form action="#" id="FormRateEntry">
              <div class="form-row">
              <div class="row" style="margin-bottom:5px;">
		        <div class="col-4 col-sm-4 col-md-5">Date :-</div>
		        <div class="col-6 col-sm-6 col-md-6" id="entryDateDiv">
		        		<input class="form-control" id="entryDate" name="entryDate" type="text">
		        </div>
		         <div class="col-6 col-sm-6 col-md-6" id="updateDateDiv">
		         	<select class="form-control" id="updateEntryDate" name="entryDate">
                        <option value=""></option>
                      </select> 
                  </div>
		      </div>
		      
                <table id="RateEntry-FormBody" class="table table-inverse" >
	              <tbody>
	                <tr>
	                  <th scope="row">Permanent</th>
	                  <td><input class="form-control" id="permanent" style="width: 12%" name="permanent" type="text" value="0"></td>
	                </tr>
	                <tr>
	                  <th scope="row">Special Badly</th>
	                  <td><input class="form-control" id="specialBadly" style="width: 12%" name="specialBadly" type="text" value="0"></td>
	                </tr>
	                <tr>
	                  <th scope="row">Badly</th>
	                  <td><input class="form-control" id="badly" style="width: 12%" name="badly" type="text" value="0"></td>
	                </tr>
	                <tr>
	                  <th scope="row">Learner (LN)</th>
	                  <td><input class="form-control" id="learner" style="width: 12%" name="learner" type="text" value="0"></td>
	                </tr>
	                <tr>
	                  <th scope="row">Semi Skilled (TT)</th>
	                  <td><input class="form-control" id="semiSkilled" style="width: 12%" name="semiSkilled" type="text" value="0"></td>
	                </tr>
	                <tr>
	                  <th scope="row">New Entrance</th>
	                  <td><input class="form-control" id="newEntrance" style="width: 12%" name="newEntrance" type="text" value="0"></td>
	                </tr>
	                <tr>
	                  <th scope="row">Outsider Source (O/S)</th>
	                  <td><input class="form-control" id="outsider" style="width: 12%" name="outsider" type="text" value="0"></td>
	                </tr>
	                <tr>
	                  <th scope="row">Other Mill (O/M)</th>
	                  <td><input class="form-control" id="otherMill" style="width: 12%" name="otherMill" type="text" value="0"></td>
	                </tr>
	                <tr>
	                  <th scope="row">Voucher/Retired</th>
	                  <td><input class="form-control" id="voucherRet" style="width: 12%" name="voucherRet" type="text" value="0" ></td>
	                </tr>
	              </tbody>
	            </table>
	            <div class="row">
	            	<div class="col-1 col-sm-2 col-md-4"><button class="btn btn-success btn-lg btn-block" type="button" id="submit" data-dismiss="modal">Save</button></div>
	            	<div class="col-1 col-sm-2 col-md-4"><button class="btn btn-info btn-lg btn-block" type="button" id="query" data-dismiss="modal">Query</button></div>
	            	<div class="col-1 col-sm-2 col-md-4"><button class="btn btn-danger btn-lg btn-block" type="reset" id="cancel" data-dismiss="modal">Cancel</button></div>
	            </div>
              </div>
              </form>
          </div>
        </div>
      </div>
    </div>
  </div>
<script type="text/javascript">
requestObject.operationName=requestObject.operationType.SAVE;
requestObject.activePage=requestObject.pageNameList.Rate;
</script>