import React from 'react';
import TextField from '@material-ui/core/TextField';

import global_data from '../../store/global_data';

interface Props {
  index: number;
}

function ClientFormPhone(props: Props) {
  const { index } = props;

  const onChange: any = (event: any) => {
    const input: string = event.target.value;

    global_data.clientForms[index].phone = input;
  };

  return (
    <TextField id={'client-form-phone-' + index} label="Phone"
      defaultValue={global_data.clientForms[index].phone} margin="dense" onChange={onChange}/>
  );
}

export default ClientFormPhone;
