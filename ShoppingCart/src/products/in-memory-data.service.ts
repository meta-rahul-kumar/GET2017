import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Product } from './Product';
export class InMemoryDataService implements InMemoryDbService {
    createDb() {
        const products : Product[] = [
            {
              id: 1,
              name: 'Yonex Badminton',
              price: 320,
              quantity: 27,
              rating: 5,
              seller: "Gaurav Sports",
              thumbnail: 'https://images-na.ssl-images-amazon.com/images/I/415QcJHqk8L._SY355_.jpg',
            },
            {
              id: 2,
              name: 'Nikon D5500 DSLR Camera',
              price: 24200,
              quantity: 2,
              thumbnail: "https://image1.pricedekho.com/p/2/1595689/6527393-nikon-d5500-dslr-camera-with-af-s-vr-nikkor-18-140mm-f35-56g-ed-vr-lens-black-picture-big.jpg",
              rating: 7.7,
              seller: "Vikash Digital Store",
            },
            {
              id: 3,
              name: 'Rolex Watch',
              price: 48200,
              quantity: 9,
              thumbnail: "https://www.collectorsquare.com/images/products/333665/thumbmini-rolex-watch-in-stainless-steel.jpg",
              rating: 6.5,
              seller: "Riddhi Siddhi Watches",
            },
            {
              id: 4,
              name: 'Yamaha Speakers',
              price: 33100,
              quantity: 77,
              thumbnail: "https://image2.pricedekho.com/p/96/1042003/3580947-yamaha-nsf-160-laptop-speaker-black-2-channel-picture-big.jpg",
              rating: 5.9,
              seller: "Vishata Speakers",
            },
            {
              id: 5,
              name: 'Shoppers Football',
              price: 3299,
              quantity: 62,
              thumbnail: "https://cdn.shopclues.com/images/thumbnails/55350/200/200/13cr71486488273.jpg",
              rating: 6.8,
              seller: "Prakash Sports",
            },
            {
              id: 6,
              name: 'Dell S2240T Monitor',
              price: 10700,
              quantity: 4,
              thumbnail: "http://images.buyingiq.com/p/109/1608963/3898776-dell-215-inch-touchscreen-monitor-picture-big.jpg",
              rating: 9.2,
              seller: "The Monitor Shop",
            },
            {
              id: 7,
              name: 'Z\'TON Table Tennis Racket',
              price: 2200,
              quantity: 23,
              thumbnail: "https://ae01.alicdn.com/kf/HTB1sM2ePXXXXXbCXFXXq6xXFXXXs/zton-table-tennis-racket-bag-pingpong-racket-bag.jpg_200x200.jpg",
              rating: 4.4,
              seller: "EWS Retailer",
            },
            {
              id: 8,
              name: '4 Pc. of Plastic Bottels',
              price: 200,
              quantity: 17,
              thumbnail: "https://i.pinimg.com/originals/09/62/5a/09625a7f7a9b25a0bdf8868987be537a.jpg",
              rating: 3.2,
              seller: "Priya Grossery Store",
            },
            {
              id: 9,
              name: 'Redmi 4',
              price: 8999,
              quantity: 53,
              thumbnail: "https://www.dhresource.com/200x200s/f2-albu-g5-M00-D9-D3-rBVaI1g2vkCAOE1eAAIyL1x9jpk825.jpg/4g-lte-xiaomi-redmi-4-touch-id-2gb-16gb-64.jpg",
              rating: 8.1,
              seller: "Digital Mobile Shop",
            },
            {
              id: 10,
              name: 'Puma Blue Sneakers',
              price: 1270,
              quantity: 15,
              thumbnail: "https://cdn.shopclues.com/images/thumbnails/51352/200/200/3621260311483167297.jpg",
              rating: 9.0,
              seller: "Trends Fashion Hub",
            }
          ];

    return {products};
  }
}