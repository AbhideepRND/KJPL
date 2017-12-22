$(document).ready(function(){
             
       $("#DailyHands-FormSubmit #DailyHands-FormBody .form-control").on("change blur keyup",function(e){
        obj = $(this)
        
        try{
            if(isNaN(obj.val())) throw "Not a number";
        } catch(err){
            obj.addClass("is-invalid")
            obj.trigger("focus");
            return false;
        }
            obj.removeClass("is-invalid")
            idVal = obj.attr("id");
            rowNum = idVal.substring(0,4);
            temp=0;
            for(i=1;i<=3;i++){
                    temp=temp+parseInt($("#"+rowNum+i).val())
            }
            $("#"+rowNum+4).val(temp);
            
            if(e.keyCode === 13){

                _colIndex = parseInt(idVal.substring(4,5));
                if(_colIndex === 4 ){
                    _rowIndex = parseInt(idVal.substring(3,4));
                    $('#row'+(_rowIndex+1)+(1)).focus();
                    e.preventDefault();
                } else {
                    $('#'+rowNum+(_colIndex+1)).focus();
                    e.preventDefault();
                }
            }
            return true;
       });

       $("#DailyHands-FormSubmit #DailyHands-FormBody .form-control").on("focus",function(e){
        $(this).select();
       });

       $("#DailyHands-FormSubmit #submit").on("click", function(){
            validateForm(this)
       });

       function validateForm(obj){

            alert('hello')


       }


       // Rate entry Form 
       $('#RateEntry #submit').on('click', function(){
    	   var rateEntryDate =$('#RateEntry #entryDate').val();
    	   /*if(rateEntryDate === '' || rateEntryDate === 'undefined'){
    		   alert(requestObject.formMessage.error['Date']);
    		   return false;
    	   }*/
    	   
    	   var json={};
    	   console.log($('#RateEntry-FormBody :input[type=text]').length);
    	   $('#RateEntry-FormBody :input[type=text]').each(function(index,data){
    		   json[$(data).attr('name')]=$(data).val();
    	   })
    	   console.log(JSON.stringify(json));
    	   
    	   
    	   
       })
       
       
       
    });

    