/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


const scheduleCarouselEl = $("#schedule-carousel");
const scheCarouselPrevButtonEl = $("#schedule-carousel-prev-btn");
const scheCarouselNextButtonEl = $("#schedule-carousel-next-btn");
const carouselItems = document.querySelectorAll('#schedule-carousel > .carousel-inner > .carousel-item');
const FIRST_INDEX = 0;

carouselItems[FIRST_INDEX].classList.add('active');

