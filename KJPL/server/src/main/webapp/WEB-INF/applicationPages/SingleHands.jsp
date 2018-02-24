<div class="content-wrapper">
    <!-- Actual Body Part -->
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <div class="row">
        <div class="col-12">
          <h1>Single Hand Entry</h1>
          <p>Here you can add the hands for Staff, Jute & Selection etc</p>
          <div class="form-group" id="SingleHands">
          	<form action="#" id="FormSingleHands">
              <div class="form-row">
              <div class="row" style="margin-bottom:20px;">
		        <div class="col-2 col-sm-2 col-md-2">Date :-</div>
		        <div class="col-3 col-sm-3 col-md-3" id="entryDateDiv">
		        		<input class="form-control" id="entryDate" name="entryDate" type="text">
		        </div>
                  <div class="col-2 col-sm-3 col-md-3">Production (In M/T)</div>
                  <div class="col-3 col-sm-3 col-md-3" id="">
		         	<input class="form-control number" type="text" placeholder="Add Production Data" name="production" id="production">
                  </div>
                  
                 
                  </div>
		      </div>
		      <div class="form-row">
		      	  <div class="col-1 col-sm-1 col-md-1">Dept-Code</div>
		      	  <div class="col-2 col-sm-3 col-md-3">
		      	  	<select class="form-control" id="deptCode" name="deptCode">
                     			</select> 
		      	  </div>
		      	  <div class="col-1 col-sm-1 col-md-1">Hands</div>
                  <div class="col-3 col-sm-3 col-md-3" id="">
		         	<input class="form-control number" width="10" type="text" placeholder="SingleHands" value='0' name="handValue" id="handValue">
                  </div>
		      </div>
		      	 
		      <div class="form-row">
	            <div class="row" style="margin-top:40px;">
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
requestObject.activePage=requestObject.pageNameList.SingleHand;
</script>