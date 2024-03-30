export interface CartDto {
  id?: number;
  customerId?: number;
  quantity?: number;
  price?: string;
  sumPerOne?: number;
  image?: string;
  name?: string;
  totalBill?: number;
  productId?: number;
  datePayment?: string;
}
