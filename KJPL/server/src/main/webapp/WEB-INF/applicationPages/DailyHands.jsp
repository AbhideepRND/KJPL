 <div class="content-wrapper">
    <!-- Actual Body Part -->
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
          <h4>Hands Entry</h4>
          <p>Here you can entry/edit the hands report</p>
          <form action="#" id="FormDailyHands">
          <table class="table table-inverse" id="DailyHandsFormHeader">
              <tbody>
                <tr>
                  <th>Date</th>
                  <th><input class="form-control" id="entryDate" name="entryDate" type="text"></th>
                  <th></th>
                  <th colspan="2">Production (In M/T)</th>
                  <th colspan="2">
                      <input class="form-control" type="text" placeholder="Add Production Data" name="production" id="production">
                  </th>
                  <th></th>
                </tr>
                <tr>
                  <th>Dept-Code</th>
                  <th colspan="2">
                      <select class="form-control" id="deptCode" name="deptCode">
                      </select> 
                  </th>
                  <th>Unit</th>
                  <th> 
	                  <select class="form-control" id="unit" name="unit" id="unit" readonly>
	                      <option value="M">Main Mill</option>
	                      <option value="F">Fine Unit</option>
	                  </select> 
                  </th>
                  <th>Category</th>
                  <th><input class="form-control" type="text" name="category" readonly></th>
                </tr>
                <tr>
                  <th>Entry Type</th>
                  <th colspan="2">
                     <select class="form-control" id="entryType" name="entryType">
                      <option value="P">Normal Hours</option>
                      <option value="O">Over Time</option>
                      <option value="D">Day Off</option>
                      <option value="A">Additional O.T</option>
                    </select> 
                  </th>
                   <th colspan="4"></th>
                </tr>
              </tbody>
          </table>
          <table class="table table-inverse" id="DailyHands-FormBody">
              <thead>
                <tr>
                  <th>Shift</th>
                  <th>A</th>
                  <th>B</th>
                  <th>C</th>
                  <th>Total</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">Permanent</th>
                  <td><input class="form-control" id="row11" name="permanentA" type="text" value="0"></td>
                  <td><input class="form-control" id="row12" name="permanentB" type="text" value="0"></td>
                  <td><input class="form-control" id="row13" name="permanentC" type="text"  value="0"></td>
                  <th><input class="form-control" id="row14" type="text" readonly></th>
                </tr>
                <tr>
                  <th scope="row">Special Badly</th>
                  <td><input class="form-control" id="row21" name="specialBadlyA" type="text" value="0"></td>
                  <td><input class="form-control" id="row22" name="specialBadlyB" type="text" value="0"></td>
                  <td><input class="form-control" id="row23" name="specialBadlyC" type="text"  value="0"></td>
                  <th><input class="form-control" id="row24" type="text" readonly></th>
                </tr>
                <tr>
                  <th scope="row">Badly</th>
                  <td><input class="form-control" id="row31" name="badlyA" type="text" value="0"></td>
                  <td><input class="form-control" id="row32" name="badlyB" type="text" value="0"></td>
                  <td><input class="form-control" id="row33" name="badlyC" type="text"  value="0"></td>
                  <th><input class="form-control" id="row34" type="text" readonly></th>
                </tr>
                 <tr>
                  <th scope="row">Semi Skilled (TT)</th>
                  <td><input class="form-control" id="row51" name="semiSkilledA" type="text" value="0"></td>
                  <td><input class="form-control" id="row52" name="semiSkilledB" type="text" value="0"></td>
                  <td><input class="form-control" id="row53" name="semiSkilledC" type="text"  value="0"></td>
                  <th><input class="form-control" id="row54" type="text" readonly></th>
                </tr>
                <tr>
                  <th scope="row">Learner (LN)</th>
                  <td><input class="form-control" id="row41" name="learnerA" type="text" value="0"></td>
                  <td><input class="form-control" id="row42" name="learnerB" type="text" value="0"></td>
                  <td><input class="form-control" id="row43" name="learnerC" type="text"  value="0"></td>
                  <th><input class="form-control" id="row44" type="text" readonly></th>
                </tr>
                <tr>
                  <th scope="row">New Entrance</th>
                  <td><input class="form-control" id="row61" name="newEntranceA" type="text" value="0"></td>
                  <td><input class="form-control" id="row62" name="newEntranceB" type="text" value="0"></td>
                  <td><input class="form-control" id="row63" name="newEntranceC" type="text"  value="0"></td>
                  <th><input class="form-control" id="row64" type="text" readonly></th>
                </tr>
                <tr>
                  <th scope="row">Outsider Source (O/S)</th>
                  <td><input class="form-control" id="row71" name="outsiderA" type="text" value="0"></td>
                  <td><input class="form-control" id="row72" name="outsiderB" type="text" value="0"></td>
                  <td><input class="form-control" id="row73" name="outsiderC" type="text"  value="0"></td>
                  <th><input class="form-control" id="row74" type="text" readonly></th>
                </tr>
                <tr>
                  <th scope="row">Other Mill (O/M)</th>
                  <td><input class="form-control" id="row81" name="otherMillA" type="text" value="0"></td>
                  <td><input class="form-control" id="row82" name="otherMillB" type="text" value="0"></td>
                  <td><input class="form-control" id="row83" name="otherMillC" type="text"  value="0"></td>
                  <th><input class="form-control" id="row84" type="text" readonly></th>
                </tr>
                <tr>
                  <th scope="row">Voucher/Retired</th>
                  <td><input class="form-control" id="row91" name="voucherRetA" type="text" value="0" ></td>
                  <td><input class="form-control" id="row92" name="voucherRetB" type="text" value="0"></td>
                  <td><input class="form-control" id="row93" name="voucherRetC" type="text"  value="0"></td>
                  <th><input class="form-control" id="row94" type="text" readonly></th>
                </tr>
                <tr>
                  <th scope="row"></th>
                  <td></td>
                  <td><button class="btn btn-success btn-lg btn-block" type="button" id="submit" data-dismiss="modal">Save</button></td>
                  <td><button class="btn btn-info btn-lg btn-block" type="button" id="query" data-dismiss="modal">Query</button></td>
                  <td><button class="btn btn-danger btn-lg btn-block" type="button" id="cancel" data-dismiss="modal" >Cancel</button></td>
                </tr>
              </tbody>
            </table>
          </form>
        </div>
      </div>
    </div>
 </div>
<script type="text/javascript" >
requestObject.operationName=requestObject.operationType.SAVE;
requestObject.activePage=requestObject.pageNameList.DailyHand;
</script>>