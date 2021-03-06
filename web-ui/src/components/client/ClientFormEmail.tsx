import React from 'react';
import TextField from '@material-ui/core/TextField';

import global_data from '../../store/global_data';

interface Props {
  index: number;
}

function ClientFormEmail(props: Props) {
  const { index } = props;

  const onChange: any = (event: any) => {
    const input: string = event.target.value;

    global_data.clientForms[index].email = input;
  };

  return (
    <TextField id={'client-form-email-' + index} label="Email"
      defaultValue={global_data.clientForms[index].email} margin="dense" onChange={onChange}/>
  );
}

export default ClientFormEmail;
