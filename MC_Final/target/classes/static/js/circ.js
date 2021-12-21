
$(document).ready(function(){
	const memberID = "aaa";
			
	$.post("updateChart1", {memberID}, function(msg){
		
		
		const kcal = JSON.parse(msg).kcal;
		const kcalC = kcal/20; //칼로리 퍼센테이지 계산 2000kcal를 기준
		const kcalCp =kcalC.toFixed(0);
		//console.log(kcalC); // 
		const carb = JSON.parse(msg).carb;
		const carbC = carb/392*100;
		const carbCp = carbC.toFixed(0);
		
		
		const prot = JSON.parse(msg).prot;
		const protC = prot/235*100;
		const protCp = protC.toFixed(0);
		
		const fat = JSON.parse(msg).fat;
		const fatC = fat/70*100;
		const fatCp = fatC.toFixed(0);
		
		
		
		//막대 바 시작//
		(function( $ ) {
		    "use strict";
		    $(function() {
		        function animated_contents() {
		            $(".zt-skill-bar > div ").each(function (i) {
		                var $this  = $(this),
		                    skills = $this.data('width');

		                 $this.css({'width' : kcalC + '%'});
		                 $('.cal').append( kcal +"/2000kcal")
		                 $('.per').append(kcalC+"%")
		                 $('.carb1').append(carb+"/392 ("+carbCp+"%)")
		                 $('.prob1').append(prot+"/235 ("+protCp+"%)")
		                 $('.fat1').append(fat+"/70 ("+fatCp+"%)")
		            });
		        }
		        
		        if(jQuery().appear) {
		            $('.zt-skill-bar').appear().on('appear', function() {
		                animated_contents();
		            });
		        } else {
		            animated_contents();
		        }
		    });
		}(jQuery));
		//막대 바 끝//
		$('#chart1').attr('data-percent',carbCp);
		    
			
			$('#chart1').easyPieChart({
			barColor: '#ff9998',
		    trackColor: 'rgba(0,0,0,0.1)',
		    scaleColor: 'black',
		    lineCap: 'butt',
		    lineWidth: 30,
		    size: 200,
		    animate: 1000,
		    onStart: $.noop,
		    onStop: $.noop
		  } );
		$('#chart2').attr('data-percent',protCp);
	
		$('#chart2').easyPieChart({
			
		    barColor: '#ff9998',
		    trackColor: 'rgba(0,0,0,0.1)',
		    scaleColor: 'black',
		    lineCap: 'butt',
		    lineWidth: 30,
		    size: 200,
		    animate: 1000,
		    onStart: $.noop,
		    onStop: $.noop
		  });
		$('#chart3').attr('data-percent',fatCp);
		//$('#chart1').attr('class','chart chart1_1');
		$('#chart3').easyPieChart({
			
		    barColor: '#ff9998',
		    trackColor: 'rgba(0,0,0,0.1)',
		    scaleColor: 'black',
		    lineCap: 'butt',
		    lineWidth: 30,
		    size: 200,
		    animate: 1000,
		    onStart: $.noop,
		    onStop: $.noop
		  });

	
	}); 
	});
	
//});
/* 
$('.chart1').easyPieChart({
	
    barColor: '#ff9998',
    trackColor: '#d6cece',
    scaleColor: 'black',
    lineCap: 'butt',
    lineWidth: 30,
    size: 200,
    animate: 1000,
    onStart: $.noop,
    onStop: $.noop
  });

  $('.chart2').easyPieChart({
	  barColor: '#ff9998',
	    trackColor: '#d6cece',
	    scaleColor: 'black',
	    lineCap: 'butt',
	    lineWidth: 30,
	    size: 200,
	    animate: 1000,
	    onStart: $.noop,
	    onStop: $.noop
  }); 

  $('.chart3').easyPieChart({
	  barColor: '#ff9998',
	    trackColor: '#d6cece',
	    scaleColor: 'black',
	    lineCap: 'butt',
	    lineWidth: 30,
	    size: 200,
	    animate: 1000,
	    onStart: $.noop,
	    onStop: $.noop
  });
 */
