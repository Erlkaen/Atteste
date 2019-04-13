import { Mail } from './mail';

export class Certificat {
  id: number;
  notBefore: Date;
  notAfter: Date;
  mails: Mail[];
}
