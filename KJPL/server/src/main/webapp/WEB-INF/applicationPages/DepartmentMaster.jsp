<div class="content-wrapper">
    <!-- Actual Body Part -->
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <div class="row">
        <div class="col-12">
          <h1>Department Master</h1>
          <p>Here you can create the master for department</p>
          <div class="form-group" id="departmentMaster">
          	<form action="#" id="FormDepartmentMaster">
              <div class="form-row">
               	<label class="col-sm-2">Dept-Code</label>
			    <div class="col-sm-2" id="inputDeptDiv">
			      <input type="text" class="form-control" name="deptCode" id="insertDeptCode" value="">
			    </div>
			    <div class="col-sm-2" id="updateDeptDiv">
			      <select class="form-control" id="updateDeptCode" name="deptCode" id="updateDeptCode">
                      <option value=""></option>
                  </select> 
			    </div>
			    <div class="col-sm-1">&nbsp;</div>
			    <label >Description &nbsp;</label>
			    <div class="col-sm-3">
			    	<input type="text" class="form-control" name="description" id="description" value="">
			    </div>
			  </div>
			  <br>
			  <div class="form-row">
			    <label class="col-sm-2">Unit</label>
			    <div class="col-sm-2">
			      <select class="form-control" id="unit" name="unit" id="unit">
                      <option value="M">Main Mill</option>
                      <option value="F">Fine Unit</option>
                  </select> 
			    </div>
			    <div class="col-sm-1">&nbsp;</div>
			    <label >Category &nbsp;</label>
			    <div class="col-sm-3">
			    	<select class="form-control" id="unit" name="category" id="category">
                      <option value="P">Shift Entry</option>
                      <option value="S">Single Hands</option>
                  </select> 
			    </div>
			  </div>
			  <br>
			  <br>
			  <div class="form-row">
			    <div class="col-1">
			      <button class="btn btn-primary btn-sm btn-success" type="button" id="submit" data-dismiss="modal">Save</button>
			    </div>
			    <div class="col-1">
			      <button class="btn btn-secondary btn-sm btn-info " type="button" id="query" data-dismiss="modal">Query</button>
			    </div>
			    <div class="col-1">
			      <button class="btn btn-primary btn-sm btn-danger " type="button" id="cancel" data-dismiss="modal">Cancel</button>
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
requestObject.activePage=requestObject.pageNameList.Department;
</script>
