import React from 'react';
import TextField from '@material-ui/core/TextField';

import global_data from '../../store/global_data';

interface Props {
  index: number;
}

function ClientFormName(props: Props) {
  const { index } = props;

  const onChange: any = (event: any) => {
    const input: string = event.target.value;

    global_data.clientForms[index].name = input;
  };

  return (
    <TextField id={'client-form-name-' + index} label="Name"
      defaultValue={global_data.clientForms[index].name} margin="dense" onChange={onChange}/>
  );
}

export default ClientFormName;
