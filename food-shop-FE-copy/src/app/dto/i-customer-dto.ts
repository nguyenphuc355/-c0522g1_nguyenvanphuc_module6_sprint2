
import {IUser} from '../model/i-user';

export interface ICustomerDto {
  name?: string;
  dayOfBirth?: string;
  gender?: number;
  idCard?: string;
  email?: string;
  address?: string;
  phoneNumber?: string;
  user?: IUser;
}
